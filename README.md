# Lesson_15 Регулярные выражения

1️⃣ 🟢
– Создай класс BlrPassport, описывающий данные белорусского паспорта

– В классе хранится фамилия на латинице, имя на латинице, пол, дата рождения, номер паспорта, идентификационный номер, дата выдачи, срок действия (дата)

– Внутри конструктора проведи валидацию данных. Упади с ошибкой, если данные невалидные

– Номер паспорта: два символа из предложенных (AB, BM, HB, KH, MP, MC, KB, PP, SP, DP), 7 цифр. Проверить через регулярные выражения

– Идентификационный номер: 7 цифр, буква из предложенных (A, B, C, K, E, M, H), 3 цифры, 2 буквы из предложенный (PB, BA, BI), 1 цифра. Проверь через регулярные выражения

– Дата выдачи раньше срока действия

– Объяви метод toString, возвращающий строковое представление данных в свободном формате

– Объяви метод boolean isExpired(LocalDate now), который проверяет, просрочен ли паспорт. На вызывающей стороне передаём аргумент LocalDate.now(ZoneId.of("Europe/Minsk"))

– В отдельном классе напиши демонстрацию работы класса

2️⃣ 🟡
Допустим, мы делаем некоторый детский сайт, где любые пользователи могут оставлять текстовые сообщения. Например, это может быть секция комментариев пользователей к некоторому контенту (например, как в YouTube). Мы хотим, чтобы оскорбительные, нецензурные, вульгарные выражения не отображались на сайте.

– Создай класс TextBlackListFilter.

– Конструктор класса должен принимать массив строк – множество неприемлемых слов и выражений.

– Объяви метод, который принимает некоторый текст (допустим, комментарий пользователя) и возвращает, содержит ли он неприемлемые слова.

– Объяви метод, который принимает некоторый текст и возвращает, сколько неприемлемых слов он содержит.

– Объяви метод, который принимает некоторый текст и возвращает модифицированный текст, где неприемлимые слова заменены строкой “####”.

– Должны искаться отдельно стоящие слова, а не подстроки.

– Неприемлемые выражения должны искаться нечувствительно к регистру.

– Неприемлемые выражения могут содержать любые Unicode символы.

– Текст может содержать переносы строки.

– В отдельном классе напиши демонстрацию работы класса.

– Неприемлемые слова запроси у пользователя через консоль. Пользователь вводит список слов как одну строку, отделяя слова запятыми (возможно, с пробелами). Чтобы привести такую строку к массиву используй метод split(…) класса String. Например из “  слово1, слово2 ,  слово слово слово3 ” должен получиться массив {“слово1”, “слово2”, “слово слово слово3”}

– Создай один объект TextBlackListFilter для демонстрации его методов. Аргументы запрашиваются у пользователя из консоли.
