package calculator.model

class DecimalFromStart(calc: Calculator) extends CalculatorState(calc: Calculator){


  override def numberPressed(): Unit = {
   calc.numbers += calc.currentNum*Math.pow(10.0, -calc.n)
    calc.n += 1.0
    val n: Double = calc.numbers
    calc.LHS = n
  }

  override def EqualPress(): Unit = {
    calc.nWipe()
  }
  override def DecimalPress(): Unit = {
  }
  override def AddPress(): Unit = {
    calc.nWipe()
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.nWipe()
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.nWipe()
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.nWipe()
    calc.state = new Divide(calc)
  }
}
