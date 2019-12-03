package BNN

import chisel3._
import chisel3.util._

class PE extends Module{
    val io = IO(new Bundle{
        val weight = Input(UInt(1.W))
        val feature = Input(UInt(4.W)) 
        val fact = Output(UInt(4.W))
    })
    val fullWeight = Fill(4,io.weight)
    io.fact := ~(fullWeight ^ io.feature) + io.weight    
}
