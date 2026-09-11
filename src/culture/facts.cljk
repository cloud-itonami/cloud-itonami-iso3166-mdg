(ns culture.facts
  "Country-level regional-culture catalog for Madagascar (MDG) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"MDG"
   [{:culture/id "mdg.dish.romazava"
     :culture/name "Romazava"
     :culture/country "MDG"
     :culture/kind :dish
     :culture/summary "National dish of Madagascar, consisting of greens, zebu meat, tomatoes and onions, typically accompanied by rice."
     :culture/url "https://en.wikipedia.org/wiki/Romazava"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.dish.ravitoto"
     :culture/name "Ravitoto"
     :culture/country "MDG"
     :culture/kind :dish
     :culture/summary "Traditional dish in Malagasy cuisine of crushed cassava leaves cooked with garlic and fatty pork."
     :culture/url "https://en.wikipedia.org/wiki/Ravitoto"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.dish.mofo-gasy"
     :culture/name "Mofo gasy"
     :culture/country "MDG"
     :culture/kind :dish
     :culture/summary "Malagasy breakfast food made from a batter of sweetened rice flour poured into greased circular molds."
     :culture/url "https://en.wikipedia.org/wiki/Malagasy_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.product.vanilla"
     :culture/name "Madagascar vanilla"
     :culture/country "MDG"
     :culture/kind :product
     :culture/summary "In 2023, world production of raw vanilla was 7,433 tonnes, led by Madagascar with 42% of the total; Madagascar's and Indonesia's cultivations together produce two-thirds of the world's vanilla supply."
     :culture/url "https://en.wikipedia.org/wiki/Vanilla"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.festival.famadihana"
     :culture/name "Famadihana"
     :culture/country "MDG"
     :culture/kind :festival
     :culture/summary "Malagasy funerary tradition in which families bring forth the bodies of their ancestors from the family crypts, rewrap the corpses in fresh cloth, and dance while carrying them."
     :culture/url "https://en.wikipedia.org/wiki/Famadihana"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.heritage.tsingy-de-bemaraha"
     :culture/name "Tsingy de Bemaraha Strict Nature Reserve"
     :culture/country "MDG"
     :culture/kind :heritage
     :culture/summary "UNESCO World Heritage Site in Madagascar, designated in 1990, recognized for its unique geography, preserved mangrove forests, and wild bird and lemur populations."
     :culture/url "https://en.wikipedia.org/wiki/Tsingy_de_Bemaraha_Strict_Nature_Reserve"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "mdg.heritage.royal-hill-of-ambohimanga"
     :culture/name "Royal Hill of Ambohimanga"
     :culture/country "MDG"
     :culture/kind :heritage
     :culture/summary "Fortified royal settlement northeast of Antananarivo and UNESCO World Heritage Site, associated with strong feelings of national identity and maintaining its spiritual and sacred character for centuries."
     :culture/url "https://en.wikipedia.org/wiki/Royal_Hill_of_Ambohimanga"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-mdg culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "MDG"))
                 " MDG entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
