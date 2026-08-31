# Проект 11 – Билети
Проектът следва общата структура: просто приложение с команден интерфейс (CLI), отделни пакети за CLI, константи, изключения, модел, хранилище, услуги, сесия и помощни програми. При реализацията умишлено са избегнати сложните дизайнерски модели и външните библиотеки.

## Run

Compile:
bash
javac -d out $(find src -name "*.java")

Run:
bash
java -cp out Application


## Main commands

- `open sample.xml`
- `addevent Hamlet 2026-09-15 1`
- `freeseats Hamlet 2026-09-15`
- `book Hamlet 2026-09-15 1 1 note`
- `unbook Hamlet 2026-09-15 1 1`
- `buy Hamlet 2026-09-15 1 2`
- `bookings`
- `check 24621650-0001`
- `report 2026-09-15`
- `save`
- `saveas result.xml`
- `close`
- `help`
- `exit`
