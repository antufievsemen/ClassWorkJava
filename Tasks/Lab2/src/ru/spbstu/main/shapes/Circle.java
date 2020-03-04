package ru.spbstu.main.shapes;

import java.util.Random;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Ellipse{

  private float x;
  private float y;
  private float radius;

  public Circle(float x, float y, float radius){
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @Override
  public float getX() {
    return x;
  }

  @Override
  public float getY() {
    return y;
  }

  @Override
  public double getArea() {
    return radius * radius * Math.PI;
  }

  @Override
  public double getLength() {
    return 2 * Math.PI * radius;
  }

  /*
     * TODO: Реализовать класс 'Circle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
