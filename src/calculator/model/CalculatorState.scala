package calculator.model

abstract class  CalculatorState(Calc: Calculator){

  def EqualPress(): Unit

  def DecimalPress(): Unit

  def numberPressed(): Unit

  def AddPress(): Unit

  def SubtractPress(): Unit

  def MultiplyPress(): Unit

  def DividePress(): Unit
}
