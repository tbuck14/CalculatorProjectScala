package tests
import org.scalatest.FunSuite
import calculator.model.Calculator
import calculator.controller.{AdditionAction, ClearAction, DecimalAction, DivisionAction, EqualAction, MultiplicationAction, NumberAction, SubtractionAction}
class TestFullFunctionality extends FunSuite{

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
    new DivisionAction(calc10).handle(null)
    new MultiplicationAction(calc10).handle(null)
    new MultiplicationAction(calc10).handle(null)
    new SubtractionAction(calc10).handle(null)
    new SubtractionAction(calc10).handle(null)
    new AdditionAction(calc10).handle(null)
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
  test("equals Madness!!"){
    val calc11: Calculator = new Calculator
    new NumberAction(calc11, 0).handle(null)
    new NumberAction(calc11, 2).handle(null)
    new DecimalAction(calc11).handle(null)
    new NumberAction(calc11, 1).handle(null)
    new EqualAction(calc11).handle(null)
    new EqualAction(calc11).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 2.1), calc11.displayNumber())
    new AdditionAction(calc11).handle(null)
    new NumberAction(calc11, 2).handle(null)
    new DecimalAction(calc11).handle(null)
    new NumberAction(calc11, 1).handle(null)
    new SubtractionAction(calc11).handle(null)
    new NumberAction(calc11, 2).handle(null)
    new DecimalAction(calc11).handle(null)
    new NumberAction(calc11, 1).handle(null)
    new DivisionAction(calc11).handle(null)
    new NumberAction(calc11, 1).handle(null)
    new MultiplicationAction(calc11).handle(null)
    new NumberAction(calc11, 2).handle(null)
    new EqualAction(calc11).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 4.2), calc11.displayNumber())
    new EqualAction(calc11).handle(null)
    new EqualAction(calc11).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 16.8), calc11.displayNumber())
    new AdditionAction(calc11).handle(null)
    new NumberAction(calc11, 2).handle(null)
    new EqualAction(calc11).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 18.8), calc11.displayNumber())
    new ClearAction(calc11).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 0.0), calc11.displayNumber())
    new NumberAction(calc11, 2).handle(null)
    new AdditionAction(calc11).handle(null)
    new NumberAction(calc11, 2).handle(null)
    assert(equalDoubles(calc11.displayNumber(), 2), calc11.displayNumber())
  }
  test("clear_not_complete"){
    val calc12: Calculator = new Calculator
    new NumberAction(calc12, 6).handle(null)
    new AdditionAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new EqualAction(calc12).handle(null)
    new ClearAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new SubtractionAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new EqualAction(calc12).handle(null)
    new ClearAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new MultiplicationAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new EqualAction(calc12).handle(null)
    new ClearAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new DivisionAction(calc12).handle(null)
    new NumberAction(calc12, 6).handle(null)
    new EqualAction(calc12).handle(null)
    assert(equalDoubles(calc12.displayNumber(), 1), calc12.displayNumber())
    new ClearAction(calc12).handle(null)
    assert(equalDoubles(calc12.displayNumber(), 0), calc12.displayNumber())
  }
  test("equal_start_rhs"){
    val calc13: Calculator = new Calculator
    new EqualAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    new MultiplicationAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    assert(equalDoubles(calc13.displayNumber(), 16), calc13.displayNumber())
    new EqualAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    new AdditionAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    assert(equalDoubles(calc13.displayNumber(), 8), calc13.displayNumber())
    new EqualAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    new SubtractionAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    assert(equalDoubles(calc13.displayNumber(), 0), calc13.displayNumber())
    new EqualAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    new DivisionAction(calc13).handle(null)
    new NumberAction(calc13, 4).handle(null)
    new EqualAction(calc13).handle(null)
    assert(equalDoubles(calc13.displayNumber(), 1), calc13.displayNumber())
  }
  test("multiple_equals_backwards"){
    val calc14: Calculator = new Calculator
    new NumberAction(calc14, 4).handle(null)
    new AdditionAction(calc14).handle(null)
    new NumberAction(calc14, 4).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    assert(equalDoubles(calc14.displayNumber(), 20), calc14.displayNumber())
    new NumberAction(calc14, 4).handle(null)
    new SubtractionAction(calc14).handle(null)
    new NumberAction(calc14, 4).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    new EqualAction(calc14).handle(null)
    assert(equalDoubles(calc14.displayNumber(), -12), calc14.displayNumber())
  }
  test("must_press_equal"){
    val calc15: Calculator = new Calculator
    new NumberAction(calc15, 2).handle(null)
    new AdditionAction(calc15).handle(null)
    new NumberAction(calc15, 2).handle(null)
    new SubtractionAction(calc15).handle(null)
    new NumberAction(calc15, 5).handle(null)
    new MultiplicationAction(calc15).handle(null)
    new NumberAction(calc15, 5).handle(null)
    new DivisionAction(calc15).handle(null)
    new NumberAction(calc15, 5).handle(null)
    new EqualAction(calc15).handle(null)
    assert(equalDoubles(calc15.displayNumber(), -1), calc15.displayNumber())
    new EqualAction(calc15).handle(null)
    assert(equalDoubles(calc15.displayNumber(), -.2), calc15.displayNumber())
  }
  test("after pressing equal"){
    val calc16: Calculator = new Calculator
    new NumberAction(calc16, 3).handle(null)
    new AdditionAction(calc16).handle(null)
    new NumberAction(calc16, 3).handle(null)
    new EqualAction(calc16).handle(null)
    new SubtractionAction(calc16).handle(null)
    new NumberAction(calc16, 1).handle(null)
    new EqualAction(calc16).handle(null)
    new MultiplicationAction(calc16).handle(null)
    new NumberAction(calc16, 5).handle(null)
    new EqualAction(calc16).handle(null)
    new DivisionAction(calc16).handle(null)
    new NumberAction(calc16, 2).handle(null)
    new EqualAction(calc16).handle(null)
    assert(equalDoubles(calc16.displayNumber(), 12.5), calc16.displayNumber())
  }
}
