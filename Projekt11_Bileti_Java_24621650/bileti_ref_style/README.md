# Projekt 11 - Bileti

Java OOP project for faculty number **24621650**.

The project follows the general organization of the reference university project: a simple CLI application, separated packages for CLI, constants, exceptions, model, repository, services, session and utilities. The implementation intentionally avoids complicated design patterns and external libraries.

## Run

Compile:
```bash
javac -d out $(find src -name "*.java")
```

Run:
```bash
java -cp out Application
```

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
