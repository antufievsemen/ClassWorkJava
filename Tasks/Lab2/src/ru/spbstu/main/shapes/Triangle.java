package ru.spbstu.main.shapes;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Polygon{

  private float x;
  private float y;
  private float line1;
  private float line2;
  private float line3;
  private int rotate;

  public Triangle(float x, float y, float line1, float line2,float line3, int rotate) {
    this.x = x;
    this.y = y;
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
    this.rotate = rotate;
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
  public double getPerimeter() {
    return line1 + line2 + line3;
  }

  @Override
  public double getArea() {
    return Math.sqrt(getPerimeter() / 2 * (getPerimeter() / 2 - line1) * (getPerimeter() / 2 - line2) * (getPerimeter() / 2 - line3));
  }

  @Override
  public int getRotation() {
    return rotate;
  }

  /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
