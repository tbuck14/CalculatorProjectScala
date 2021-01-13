package tests

import calculator.controller.{AdditionAction, DecimalAction, EqualAction, NumberAction}
import calculator.model.Calculator
import org.scalatest.FunSuite

class TestEnterNumbers extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  // Example test case
  test("Enter Numbers Test") {
    val calculator: Calculator = new Calculator()

    new NumberAction(calculator, 1).handle(null)
    new NumberAction(calculator, 2).handle(null)
    new NumberAction(calculator, 3).handle(null)
    new NumberAction(calculator, 4).handle(null)
    new NumberAction(calculator, 5).handle(null)
    new NumberAction(calculator, 6).handle(null)
    new NumberAction(calculator, 7).handle(null)
    new NumberAction(calculator, 8).handle(null)
    new NumberAction(calculator, 9).handle(null)

    assert(equalDoubles(calculator.displayNumber(), 123456789.0), calculator.displayNumber())

  }
  test("test for decimals") {
    val calc1: Calculator = new Calculator
    new NumberAction(calc1, 8).handle(null)
    new DecimalAction(calc1).handle(null)
    new NumberAction(calc1, 8).handle(null)
    assert(equalDoubles(calc1.displayNumber(), 8.8), calc1.displayNumber())

    val calc2: Calculator = new Calculator
    new DecimalAction(calc2).handle(null)
    new NumberAction(calc2, 0).handle(null)
    new NumberAction(calc2, 0).handle(null)
    new NumberAction(calc2, 0).handle(null)
    new NumberAction(calc2, 0).handle(null)
    new NumberAction(calc2, 1).handle(null)
    assert(equalDoubles(calc2.displayNumber(), 0.00001), calc2.displayNumber())

    val calc3: Calculator = new Calculator
    new NumberAction(calc3, 1).handle(null)
    new DecimalAction(calc3).handle(null)
    new NumberAction(calc3, 1).handle(null)
    new DecimalAction(calc3).handle(null)
    assert(equalDoubles(calc3.displayNumber(), 1.1), calc3.displayNumber())

    val calc4: Calculator = new Calculator
    new NumberAction(calc4, 0).handle(null)
    new NumberAction(calc4, 0).handle(null)
    new NumberAction(calc4, 0).handle(null)
    new NumberAction(calc4, 1).handle(null)
    new DecimalAction(calc4).handle(null)
    new NumberAction(calc4, 0).handle(null)
    new DecimalAction(calc4).handle(null)
    new NumberAction(calc4, 1).handle(null)
    assert(equalDoubles(calc4.displayNumber(), 1.01), calc4.displayNumber())
  }

}
