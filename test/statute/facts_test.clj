(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [statute.facts :as facts]))

(deftest mdg-has-spec-basis
  (let [sb (facts/spec-basis "MDG")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "http") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["MDG" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["mdg.loi-2003-044-code-du-travail"]
         (mapv :statute/id (facts/by-topic "MDG" :labor))))
  (is (= ["mdg.loi-2007-036-investissements"]
         (mapv :statute/id (facts/by-topic "MDG" :investment))))
  (is (= ["mdg.loi-2003-036-societes-commerciales"]
         (mapv :statute/id (facts/by-topic "MDG" :corporate-governance))))
  (is (empty? (facts/by-topic "MDG" :environment)))
  (is (empty? (facts/by-topic "ATL" :labor))))

(deftest companies-law-cites-madagascars-own-national-law-not-an-acte-uniforme
  (testing "MDG is not an OHADA member -- companies law is Madagascar's own national statute, not an OHADA supranational Acte Uniforme"
    (let [sb (first (facts/by-topic "MDG" :corporate-governance))]
      (is (re-find #"2003-036" (:statute/law-number sb)))
      (is (not (re-find #"Acte [Uu]niforme" (:statute/law-number sb)))))))
