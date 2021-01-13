package calculator.model

class DecimalFromSubtract(calc: Calculator) extends CalculatorState(calc: Calculator){

  calc.RHS = 0
  override def numberPressed(): Unit = {
    calc.numbers += calc.currentNum*Math.pow(10.0, -calc.n)
    calc.n += 1.0
    val n: Double = calc.numbers
    calc.RHS = n
  }

  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS - calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromSubtract(calc)
  }
  override def DecimalPress(): Unit = {
  }
  override def AddPress(): Unit = {
    calc.nWipe()
    calc.SubIt()
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.nWipe()
    calc.LHS = calc.LHS - calc.RHS
    calc.numbers = 0
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.nWipe()
    calc.SubIt()
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.nWipe()
    calc.SubIt()
    calc.state = new Divide(calc)
  }
}

