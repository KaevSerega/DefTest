Чтобы запустить тесты из командной строки в Maven-проекте, вы можете использовать команду mvn test. Она выполнит все тесты в проекте с использованием плагина
Surefire.

Перед тем как запустить тесты, убедитесь, что у вас установлен Maven и у вас есть файл pom.xml в корневом каталоге проекта.

Вот как можно запустить тесты из командной строки:

1. Откройте командную строку (терминал) и перейдите в каталог проекта, содержащий файл pom.xml.
2. Выполните команду mvn test.
3. Maven скомпилирует исходные коды, выполнит все тесты и выведет результаты в командную строку.

Если вы хотите запустить только определенный тест или группу тестов, вы можете использовать параметр test с фильтром, например:
 ```bash
mvn test -Dtest=YandexTest
 ```
где YandexTest - это имя вашего тестового класса.
 #   D e f T e s t  
 