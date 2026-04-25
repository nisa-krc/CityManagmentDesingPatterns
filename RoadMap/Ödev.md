# BM324 Dönem Projesi – 1. Bölüm

## 📌 Genel Bilgi

**Ders:** Yazılım Tasarım Örüntüleri
**Üniversite:** Ankara Bilim Üniversitesi
**Dönem:** 2025-2026 Bahar

Bu projede birden fazla **design pattern** kullanarak bir uygulama geliştirilecektir.

---

## 📦 Teslim Gereksinimleri

* Kaynak kodları içeren `.zip`
* Çalıştırılabilir `.jar` (fat jar)
* UML diyagramı (tüm sınıflar + patternler)

---

## 🧩 Problem Tanımı

Verilen JSON dosyasındaki şehir verileri kullanılacaktır.
Bu verilerle aşağıdaki yapılar oluşturulmalıdır:

### 🏙️ City Sınıfı

Her şehir için:

* `name`
* `population`
* `area`
* `currentTemperature`
* `currentWeatherState` (SUNNY, CLOUDY, RAINY, SNOWY)

---

## 🧱 1. Singleton Pattern

* Şehirler JSON’dan okunmalı
* Tek bir merkezden yönetilmeli
* Bu merkez: `Repository` sınıfı
* Repository → Singleton olacak
* Şehir listesini döndüren bir metod içermeli

📎 JSON veri kaynağı: 

---

## 🔄 2. Strategy Pattern

Şehirler aşağıdaki kriterlere göre sıralanabilmeli:

* İsme göre
* Nüfusa göre
* Alana göre

Her biri ayrı strategy sınıfı olmalı.

---

## 🔁 3. Iterator Pattern

Hava durumuna göre filtreleme yapılmalı:

* SUNNY
* CLOUDY
* RAINY
* SNOWY

➡️ Her biri için ayrı iterator yazılmalı (toplam 4 adet)

---

## 💻 Kullanıcı Arayüzü (CLI)

Program çalıştığında:

```
1- Listeleme için tür seçin
2- Filtreleme için tür seçin
Çıkmak için: Q
```

### 📊 Listeleme Menüsü

```
1- İsme göre sıralama
2- Nüfusa göre sıralama
3- Yüzölçümüne göre sıralama
Çıkmak için: Q
```

### 🌦️ Filtreleme Menüsü

```
1- Güneşli şehirler
2- Bulutlu şehirler
3- Yağmurlu şehirler
4- Karlı şehirler
Çıkmak için: Q
```

---

## 📁 JSON Veri Örneği

```json
[
  { "name": "Istanbul", "population": 15719600, "area": 5343, "currentTemperature": 20, "currentWeatherState": "SUNNY" },
  { "name": "Ankara", "population": 5317215, "area": 25615, "currentTemperature": 14, "currentWeatherState": "CLOUDY" }
]
```

(Tam veri için: )

---

## 🧠 Kullanılan Design Patternler

* Singleton → Repository
* Strategy → Sıralama işlemleri
* Iterator → Hava durumu filtreleme

---

## 🎯 Amaç

* Design pattern pratiği
* JSON veri işleme
* OOP tasarım becerisi geliştirme

---
