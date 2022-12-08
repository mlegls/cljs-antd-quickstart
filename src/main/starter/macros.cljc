(ns starter.macros
  (:require [helix.core]))

(defmacro defnc 
  "Replace helix defnc to use fast-refresh by default"
  [type params & body]
  (let [[docstring params body] (if (string? params)
                                  [params (first body) (rest body)]
                                  [nil params body])
        opts? (map? (first body)) ;; whether an opts map was passed in
        opts (if opts?
               (first body)
               {})
        body (if opts?
               (rest body)
               body)
        ;; feature flags to enable by default
        default-opts {:helix/features {:fast-refresh true}}]
    `(helix.core/defnc ~type ~@(when docstring [docstring]) ~params
       ;; we use `merge` here to allow indidivual consumers to override feature
       ;; flags in special cases
       ~(merge default-opts opts)
       ~@body)))

(defmacro unwrap
  "Destructure a JS object, like `const {...rest} = obj` in JS."
  ([props obj] ; single object & properties
   (cons 'do (map (fn [x] `(defonce ~x (. ~obj ~(symbol (str "-" x))))) 
                  props)))
  ([objs] ; vector of (object, properties) pairs
   (cons 'do (for [[props obj] (partition 2 objs)]
               `(unwrap ~props ~obj)))))

(defmacro let-unwrap
  "unwrap, with let-binding"
  ([objs & body] ; single object & properties
   `(let ~(into [] (apply concat (for [[props obj] (partition 2 objs)
                                       prop props]
                                   [prop `(. ~obj ~(symbol (str "-" prop)))])))
      ~@body)))

