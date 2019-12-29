package BNN

import chisel3._
import chisel3.experimental._

// all adders delay 2 clock
// 4bits + 4bits SInt
class SIntFourAFour extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(4.W))   // input wire [3 : 0] A
    val B = Input(SInt(4.W))   // input wire [3 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(5.W))  // output wire [4 : 0] S  
  })
}

// 5bits + 5bits SInt
class SIntFiveAFive extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(5.W))   // input wire [4 : 0] A
    val B = Input(SInt(5.W))   // input wire [4 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(6.W))  // output wire [5 : 0] S  
  })
}

// 6bits + 6bits SInt
class SIntSixASix extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(6.W))   // input wire [5 : 0] A
    val B = Input(SInt(6.W))   // input wire [5 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(7.W))  // output wire [6 : 0] S  
  })
}

// 7bits + 7bits SInt
class SIntSevenASeven extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(7.W))   // input wire [6 : 0] A
    val B = Input(SInt(7.W))   // input wire [6 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(8.W))  // output wire [7 : 0] S  
  })
}

// 8bits + 8bits SInt
class SIntEightAEight extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(8.W))   // input wire [7 : 0] A
    val B = Input(SInt(8.W))   // input wire [7 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(9.W))  // output wire [8 : 0] S  
  })
}

// 9bits + 9bits SInt
class SIntNineANine extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(9.W))   // input wire [8 : 0] A
    val B = Input(SInt(9.W))   // input wire [8 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(10.W))  // output wire [9 : 0] S  
  })
}

// 10bits + 10bits SInt
class SIntTenATen extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(SInt(10.W))   // input wire [9 : 0] A
    val B = Input(SInt(10.W))   // input wire [9 : 0] B
    val CLK = Input(Clock())    // input wire CLK
    val CE = Input(Bool())      // input wire CE
    val S = Output(SInt(11.W))  // output wire [10 : 0] S  
  })
}


