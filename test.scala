class Adder{
  val io = IO(new Bundle {
    val A = Input(UInt(3.W))
	val B = Input(UInt(3.W))
	val C = Output(UInt(3.W))
  })
  
  io.C := io.A+io.B

}