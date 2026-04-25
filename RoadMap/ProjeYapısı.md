BM 324 Dönem Projesi — Analiz & Plan
Ankara Bilim Üniversitesi | 2025-2026 Bahar | BM 324 Yazılım Tasarım Örüntüleri
1. Proje Gereksinim Analizi
Fonksiyonel Gereksinimler
# Gereksinim
F1 JSON dosyasından şehir verileri okunacak
F2 Her kayıt City nesnesine dönüştürülecek
F3 Şehirler tek merkezi repository'de tutulacak (Singleton)
F4 Liste 3 farklı kritere göre sıralanabilecek (Strategy)
F5 Liste 4 hava durumuna göre filtrelenebilecek (Iterator)
F6 Windows CMD'de çalışan menü sistemi olacak
Teknik Gereksinimler
Java (Maven build sistemi)
Gson (JSON parsing)
Fat JAR (tek çalıştırılabilir dosya)
SOLID prensipleri, tek sorumluluk ilkesi
Hata yönetimi (dosya bulunamaz, bozuk JSON, geçersiz giriş)
2. Class Listesi ve Sorumlulukları
Model Katmanı
Class Sorumluluk
WeatherState
(enum)
SUNNY, CLOUDY, RAINY, SNOWY sabitlerini tanımlar
City name, population, area, currentTemperature, currentWeatherState alanlarını
taşır; getter/setter içerir
Repository Katmanı — Singleton
Class Sorumluluk
CityRepository Singleton. Tek instance tutar. JSON'dan yüklenen List<City> 'yi merkezi
yönetir. getCities() metodu ile güvenli liste döner
Service Katmanı — JSON Okuma
Class Sorumluluk
JsonCityLoader Gson ile JSON dosyasını okur, List<City> döner; dosya/parse hatalarını fırlatır
Strategy Pattern — Sıralama
Interface / Class Sorumluluk
SortStrategy (interface) sort(List<City>) metodunu tanımlar
SortByName İsme göre alfabetik sıralama
SortByPopulation Nüfusa göre büyükten küçüğe sıralama
SortByArea Alana göre büyükten küçüğe sıralama
CitySorter SortStrategy bağımlılığı alır, sort() çağrısını delege eder
Iterator Pattern — Filtreleme
Interface / Class Sorumluluk
CityIterator (interface) hasNext() ve next() metodlarını tanımlar
SunnyCityIterator Sadece SUNNY şehirleri döner
CloudyCityIterator Sadece CLOUDY şehirleri döner
RainyCityIterator Sadece RAINY şehirleri döner
SnowyCityIterator Sadece SNOWY şehirleri döner
UI Katmanı
Class Sorumluluk
ConsoleMenu Ana menüyü basar, kullanıcı girdisini okur, ilgili alt menüyü yönlendirir
SortMenu Sıralama alt menüsünü yönetir, CitySorter kullanır
FilterMenu Filtreleme alt menüsünü yönetir, ilgili Iterator'ı oluşturur
ConsoleDisplay Şehir listesini/iterator sonuçlarını ekrana basar; UI formatlaması burada
Entry Point
Class Sorumluluk
Main Uygulamayı başlatır: JsonCityLoader → CityRepository → ConsoleMenu
3. Önerilen Klasör Yapısı
city-app/
├── pom.xml
├── cities.json
└── src/
└── main/
└── java/
└── com/
└── cityapp/
├── Main.java
├── model/
│ ├── City.java
│ └── WeatherState.java
├── repository/
│ └── CityRepository.java
├── service/
│ └── JsonCityLoader.java
├── strategy/
│ ├── SortStrategy.java
│ ├── SortByName.java
│ ├── SortByPopulation.java
│ ├── SortByArea.java
│ └── CitySorter.java
├── iterator/
4. Adım Adım Geliştirme Planı
Adım İçerik Çıktı
1 pom.xml + Maven proje iskeleti + cities.json Build sistemi çalışır
2 WeatherState.java + City.java Model hazır
3 JsonCityLoader.java (Gson) JSON → List<City> çalışır
4 CityRepository.java (Singleton) Merkezi veri yönetimi hazır
5 SortStrategy interface + 3 strateji + CitySorter Strategy pattern tamamlanır
6 CityIterator interface + 4 iterator Iterator pattern tamamlanır
7 ConsoleDisplay + SortMenu + FilterMenu +
ConsoleMenu
Tam çalışan uygulama
8 Hata kontrolleri (geçersiz giriş, dosya yok, bozuk JSON) Sağlamlık iyileşir
9 pom.xml maven-shade-plugin → fat JAR java -jar city-app.jar
çalışır
10 PlantUML UML diyagramı Teslim belgesi tamamlanır
5. UMLTaslağı — Hangi Class'lar YerAlacak
│ ├── CityIterator.java
│ ├── SunnyCityIterator.java
│ ├── CloudyCityIterator.java
│ ├── RainyCityIterator.java
│ └── SnowyCityIterator.java
└── ui/
├── ConsoleMenu.java
├── SortMenu.java
├── FilterMenu.java
└── ConsoleDisplay.java
┌─────────────────────────────────────────────────────────┐
│ SINGLETON │
│ CityRepository ────────────────────────────────────► │
│ │ uses │
UML'de Görünür Olacak İlişkiler
İlişki Açıklama
Singleton CityRepository private constructor + getInstance() static metodu
Strategy CitySorter ↔ SortStrategy composition ilişkisi
Iterator FilterMenu ↔ CityIterator dependency + 4 concrete iterator'ın implements
ilişkisi
Dependency Main → JsonCityLoader → CityRepository → ConsoleMenu
│ JsonCityLoader │
└─────────────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────────────┐
│ STRATEGY │
│ <<interface>> SortStrategy │
│ ▲ │
│ ┌────┴──────────────────────────────┐ │
│ SortByName SortByPopulation SortByArea │
│ │
│ CitySorter ──── uses ──► SortStrategy │
└─────────────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────────────┐
│ ITERATOR │
│ <<interface>> CityIterator │
│ ▲ │
│ ┌────┴──────────────────────────────────┐ │
│ SunnyCityIterator CloudyCityIterator │ │
│ RainyCityIterator SnowyCityIterator │ │
└─────────────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────────────┐
│ UI (bağımlılık yalnızca yukarı doğru: UI → business) │
│ ConsoleMenu → SortMenu + FilterMenu │
│ SortMenu → CitySorter │
│ FilterMenu → *CityIterator │
│ ConsoleDisplay → City (sadece okur) │
└─────────────────────────────────────────────────────────┘
✅Analiz tamamlandı. "devam" yazıldığında Adım 1'e geçilecek: pom.xml ve Maven proje
iskeleti oluşturulacak.