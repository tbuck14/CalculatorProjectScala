package calculator.model

class DecimalFromMultiply(calc: Calculator) extends CalculatorState(calc: Calculator){

  calc.RHS = 1
  override def numberPressed(): Unit = {
    calc.numbers += calc.currentNum*Math.pow(10.0, -calc.n)
    calc.n += 1.0
    val n: Double = calc.numbers
    calc.RHS = n
  }

  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS * calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromMultiply(calc)
  }
  override def DecimalPress(): Unit = {
  }
  override def AddPress(): Unit = {
    calc.nWipe()
    calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.nWipe()
    calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.nWipe()
    calc.LHS = calc.LHS * calc.RHS
    calc.numbers = 0
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.nWipe()
    calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Divide(calc)
  }
}

