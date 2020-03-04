package ru.spbstu.main.shapes;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Polygon{

  private float x;
  private float y;
  private float width;
  private float height;
  private int rotate;

  public Rectangle(float x, float y, float width, float height, int rotate){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
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
    return 2 * width + height * 2;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public int getRotation() {
    return rotate;
  }

  /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
