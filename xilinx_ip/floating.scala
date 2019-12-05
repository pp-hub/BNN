package axi_yolo

import chisel3._
import chisel3.experimental._

// delay = 28 clocks
class FloatDiv extends BlackBox {
  val io = IO(new Bundle {
    val aclk = Input(Clock())              // input wire aclk
    val s_axis_a_tvalid = Input(Bool())    // input wire s_axis_a_tvalid
    val s_axis_a_tdata = Input(UInt(32.W)) // input wire [31 : 0] s_axis_a_tdata
    val s_axis_b_tvalid = Input(Bool())    // input wire s_axis_b_tvalid
    val s_axis_b_tdata = Input(UInt(32.W)) // input wire [31 : 0] s_axis_b_tdata
    val m_axis_result_tvalid = Output(Bool())  // output wire m_axis_result_tvalid
    val m_axis_result_tdata = Output(UInt(32.W)) // output wire [31 : 0] m_axis_result_tdata  
  })
}

// delay = 6 clocks
class FloatToInt extends BlackBox {
  val io = IO(new Bundle {
    val aclk = Input(Clock())              // input wire aclk
    val s_axis_a_tvalid = Input(Bool())    // input wire s_axis_a_tvalid
    val s_axis_a_tdata = Input(UInt(32.W)) // input wire [31 : 0] s_axis_a_tdata
    val m_axis_result_tvalid = Output(Bool())  // output wire m_axis_result_tvalid
    val m_axis_result_tdata = Output(UInt(32.W)) // output wire [31 : 0] m_axis_result_tdata  
  })
}

// delay = 6 clocks
class IntToFloat extends BlackBox {
  val io = IO(new Bundle {
    val aclk = Input(Clock())              // input wire aclk
    val s_axis_a_tvalid = Input(Bool())    // input wire s_axis_a_tvalid
    val s_axis_a_tdata = Input(SInt(32.W)) // input wire [31 : 0] s_axis_a_tdata
    val m_axis_result_tvalid = Output(Bool())  // output wire m_axis_result_tvalid
    val m_axis_result_tdata = Output(UInt(32.W)) // output wire [31 : 0] m_axis_result_tdata  
  })
}