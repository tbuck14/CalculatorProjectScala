package tests

import org.scalatest.FunSuite
import calculator.model.Calculator
import calculator.controller.{AdditionAction, SubtractionAction, DivisionAction, MultiplicationAction, EqualAction, DecimalAction, NumberAction}
class TestFourFunctions extends FunSuite{

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("test the + operator"){

    val calc6: Calculator = new Calculator
    new NumberAction(calc6, 8).handle(null)
    new DecimalAction(calc6).handle(null)
    new NumberAction(calc6, 8).handle(null)
    new AdditionAction(calc6).handle(null)
    new NumberAction(calc6, 1).handle(null)
    new DecimalAction(calc6).handle(null)
    new NumberAction(calc6, 1).handle(null)
    new EqualAction(calc6).handle(null)
    assert(equalDoubles(calc6.displayNumber(), 9.9), calc6.displayNumber())
  }
  test("test the - operator"){

    val calc7: Calculator = new Calculator
    new NumberAction(calc7, 8).handle(null)
    new DecimalAction(calc7).handle(null)
    new NumberAction(calc7, 8).handle(null)
    new SubtractionAction(calc7).handle(null)
    new NumberAction(calc7, 1).handle(null)
    new DecimalAction(calc7).handle(null)
    new NumberAction(calc7, 1).handle(null)
    new EqualAction(calc7).handle(null)
    assert(equalDoubles(calc7.displayNumber(), 7.7), calc7.displayNumber())
  }
  test("test the * operator"){

    val calc8: Calculator = new Calculator
    new NumberAction(calc8, 8).handle(null)
    new DecimalAction(calc8).handle(null)
    new NumberAction(calc8, 8).handle(null)
    new MultiplicationAction(calc8).handle(null)
    new NumberAction(calc8, 1).handle(null)
    new DecimalAction(calc8).handle(null)
    new NumberAction(calc8, 1).handle(null)
    new EqualAction(calc8).handle(null)
    assert(equalDoubles(calc8.displayNumber(), 9.68), calc8.displayNumber())
  }
  test("test the / operator"){

    val calc9: Calculator = new Calculator
    new NumberAction(calc9, 8).handle(null)
    new DecimalAction(calc9).handle(null)
    new NumberAction(calc9, 8).handle(null)
    new DivisionAction(calc9).handle(null)
    new NumberAction(calc9, 1).handle(null)
    new DecimalAction(calc9).handle(null)
    new NumberAction(calc9, 1).handle(null)
    new EqualAction(calc9).handle(null)
    assert(equalDoubles(calc9.displayNumber(), 8.0), calc9.displayNumber())
  }
  test("test for consecutive operation presses "){
    val calc10: Calculator = new Calculator
    new DecimalAction(calc10).handle(null)
    new NumberAction(calc10, 8).handle(null)
    new DecimalAction(calc10).handle(null)
    new DecimalAction(calc10).handle(null)
    new DecimalAction(calc10).handle(null)
    new NumberAction(calc10, 8).handle(null)
    new DivisionAction(calc10).handle(null)
    new MultiplicationAction(calc10).handle(null)
    new SubtractionAction(calc10).handle(null)
    new AdditionAction(calc10).handle(null)
    new DecimalAction(calc10).handle(null)
    new NumberAction(calc10, 8).handle(null)
    new DecimalAction(calc10).handle(null)
    new DecimalAction(calc10).handle(null)
    new DecimalAction(calc10).handle(null)
    new NumberAction(calc10, 8).handle(null)
    new EqualAction(calc10).handle(null)
    assert(equalDoubles(calc10.displayNumber(), 1.76), calc10.displayNumber())
  }
}
