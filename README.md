# LivestockFarmProject
SE 311 Livestock Farm Project

TR

Dört klasik nesne yönelimli tasarım kalıbının birlikte kullanımını gösteren Java tabanlı bir sığır çiftliği yönetim simülasyonu.
Kullanılan Kalıplar:

Abstract Factory — Her sığır türü (süt / et) için uyumlu yem çiftleri (protein + karbonhidrat) üretir; somut sınıfları gizler.
Observer — Bir sığır çiftlik sınırını aştığında kayıtlı çiftçilere otomatik bildirim gönderir.
Visitor — Veteriner ve bakanlık müfettişi gibi dış aktörlerin sığır sınıflarını değiştirmeden işlem yapmasını sağlar.
Singleton — Tüm sığırların GPS verilerini tutan tek bir LocationDatabase örneği olmasını garanti eder.
Adapter — Bluetooth cihazını, sunucunun beklediği Zigbee arayüzüyle uyumlu hale getirir.

EN

A Java-based cattle farm management simulation that demonstrates four classic object-oriented design patterns working together.
Patterns Used:

Abstract Factory — Creates compatible feed pairs (protein + carbohydrate) for each cattle type (dairy / beef) without exposing concrete classes.
Observer — Automatically alerts registered farmers when a cattle crosses the farm boundary.
Visitor — Allows external actors (veterinarian, ministry inspector) to perform operations on cattle without modifying cattle classes.
Singleton — Ensures a single shared LocationDatabase instance stores all cattle GPS coordinates.
Adapter — Makes a Bluetooth device compatible with the Zigbee signal interface expected by the server.

