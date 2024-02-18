### РЕФАКТОРИНГ проекта Калькулятор

Постарался использовать и применять сперва принцип **CMV**, т.е разложить проект сперва на части _controller , model и view_. 

---

Далее принцип разложил по указанным принципам **S.O.L.I.D**

#### S - Single Responsibility Principle или Принцип единственной ответственности.
Он был реализован в controller,а именно:
+ контроллер для бинарного калькулятора BinaryController
+ контроллер для калькулятора списков ListController
+ контроллер приложения AppController
---
#### O - Open Closed Principle или Принцип открытости/закрытости.
Он был реализован в model я расширил класс _Calculator_ новым классом _ListCalculator_

---
#### L - Liskov  Substitution Principle или Принцип подстановки Барбары Лисков.
Он был реализован в model и применен к классу _ListCalculator_ т.к он у нас является наследуемым от _Calculator_ , но методы sum(сумма) product(умножение) и div(деление) ,возвращают у нас тот же тип Double .

---

#### I - Interface Segregation Principle или Принцип разделения интерфейса.
Был реализован для model ,а именно разделил _Calculator_ на следующие элементы :
+ общее свойство iCalculator.
+ интерфейс реализующий бинарный калькулятор iBinaryCalculator.
+ интерфейс реализующий калькулятор списков iListCalculator.

---

#### D - Dependency Inversion Principle или Принцип инверсии зависимостей.

Был использован в controller для _Binarycontroller и ListController_ т.к они не зависят от конкретных реализаций модели. В свою очередь класс _AppController_ не зависит от конкретных реализаций _Binarycontroller и ListController_