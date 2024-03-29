(ns com.eelchat.about-us
  (:require [com.eelchat.ui :as ui]
            [rum.core :as rum]))

(defn about-page [request]
  (ui/base {:title "About Us"}
           [:div
            [:h1 "About Usssss"]
            [:p "Here's some information about our team and mission."]
            ]))
