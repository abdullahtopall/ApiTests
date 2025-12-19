# ApiTests

Bu repository, API testlerini otomatik olarak yazmak ve çalıştırmak amacıyla oluşturulmuştur. Proje Java dili ile geliştirilmiş olup **Rest Assured** kütüphanesi kullanılarak API endpoint’lerinin doğrulanması yapılmaktadır.

## Amaç
- API endpoint’lerini otomatik test etmek
- Request ve response doğrulamalarını yapmak
- Test süreçlerini daha düzenli ve tekrarlanabilir hale getirmek

## Gereksinimler
- Java 8 veya üzeri
- Maven
- IntelliJ IDEA, Eclipse veya benzeri bir IDE

## Kurulum
Repository’yi klonlayın:  
git clone https://github.com/abdullahtopall/ApiTests.git

Proje dizinine girin:  
cd ApiTests

Bağımlılıkları indirip testleri çalıştırın:  
mvn clean test

## Proje Yapısı
- `src/test/java` altında API test senaryoları yer alır
- Testler Rest Assured kullanılarak yazılmıştır
- GET, POST, PUT, DELETE gibi HTTP metodları test edilebilir

## Kullanım
- Yeni API testleri eklemek için `src/test/java` klasörüne yeni test class’ları oluşturabilirsiniz
- Endpoint URL’lerini ve request body’lerini ihtiyaca göre düzenleyebilirsiniz
- Response status code ve body doğrulamaları yapabilirsiniz

## Kullanılan Teknolojiler
- Java
- Maven
- Rest Assured
- JUnit / TestNG

## Katkıda Bulunma
1. Repository’yi fork’layın
2. Yeni bir branch oluşturun
3. Değişikliklerinizi commit edin
4. Pull Request açın

## Lisans
Bu proje açık kaynaklıdır ve eğitim/test amaçlı kullanılabilir.

## İletişim
Herhangi bir soru veya öneri için repository üzerinden issue açabilirsiniz.
