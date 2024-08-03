package org.example.templateMethod.abstr;

public abstract class AbstractClass {
    // Шаблонный метод
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        doSmth();
    }

    // Абстрактные методы, которые должны быть реализованы в подклассах
    protected abstract void primitiveOperation1();
    protected abstract void primitiveOperation2();

    // Метод, который может быть переопределен в подклассах
    protected void doSmth() {
        // Пустая реализация по умолчанию
    }
}
