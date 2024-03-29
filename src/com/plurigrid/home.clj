(ns com.plurigrid.home
  (:require [clj-http.client :as http]
            [com.biffweb :as biff]
            [com.plurigrid.middleware :as mid]
            [com.plurigrid.ui :as ui]
            [com.plurigrid.settings :as settings]
            [rum.core :as rum]
            [xtdb.api :as xt]))

(defn home-page [ctx]
  (ui/base
   (assoc ctx ::ui/recaptcha false)
   [:div.flex.justify-between.items-center.bg-orange-50.px-4.py-2
    [:div.flex.items-center.gap-2
     [:img.w-20 {:src "/img/plurigrid.png" :alt "Plurigrid logo"}]
     [:span.text-4xl.font-bold "Plurigrid"]]
    [:div.flex.items-center.gap-4
     [:a {:href "/about-us" :class "text-xl font-bold text-gray-800 hover:text-gray-600"} "About Us"]
     [:a {:href "https://vibes.lol" :class "text-xl font-bold text-gray-800 hover:text-gray-600"} "vibes.lol"]
     [:a {:href "/contact" :class "text-xl font-bold text-gray-800 hover:text-gray-600"} "Contact"]]]

   [:.bg-orange-50.flex.flex-col.flex-grow.items-center.p-5
    [:.h-30.grow]
    [:img.w-28 {:src "/img/plurigrid.png"}]
    [:.h-6]
    [:.text-2xl.sm:text-3xl.font-semibold.sm:text-center.w-full]

    [:.h-2]
    [:div.text-xl.sm:text-7xl.font-bold.sm:text-center.w-full

     "Cognition infrastructure"
     [:br]
     "for the Next Trillion Minds 🦆"]
    [:.h-6]
    [:div.bg-orange-50.flex.flex-col.items-center.p-5

     [:div.flex.justify-center.space-x-40.mt-6
      [:div.border.dashed.border-2.border-black.w-80.h-64.flex.flex-col.items-center.justify-between.rounded-lg.p-4
       [:div.flex.flex-col.items-center.my-4
        [:h2.text-xl.font-bold.text-center "act"]
        [:p.text-sm.text-center "social cognition platform applied category theory and active inference for situated cognition / microworlding kit"]]
       [:button {:class "w-3/4 bg-blue-500 text-white font-bold py-2 px-4 rounded mb-3"} "Contribute"]]

      [:div.border.dashed.border-2.border-black.w-80.h-64.flex.flex-col.items-center.justify-between.rounded-lg.p-4
       [:div.flex.flex-col.items-center.my-4
        [:h2.text-xl.font-bold.text-center "keep vibin'"]
        [:p.text-sm.text-center "vibes.lol is a compositional world modeling framework for generative models in a consensus topos"]]
       [:button {:class "w-3/4 bg-blue-500 text-white font-bold py-2 px-4 rounded mb-3"} "Flow"]]]]

    [:.h-12 {:class "grow-[10]"}]
    [:.text-sm "Member of the post-web ecosystem"]
    [:.h-6]]))

(defn about-us-page [ctx]
  (ui/page
   ctx
   [:h2.text-2xl.font-bold "About us"]
   [:p "We're a small team of researchers and developers building tools for "
    "collaborative research and learning at the mesoscale."]))

(def module
  {:routes [["" {:middleware [mid/wrap-redirect-signed-in]}
             ["/"                  {:get home-page}]]
            ["/about-us"           {:get about-us-page}]]})
