package org.team0000.example

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import org.sert2521.sertain.utils.get

object OI {
    private val joystick1 = Joystick(0)
    private val controller1 = XboxController(0)
    private val joystick2 = Joystick(2)
    private val controller2 = XboxController(2)

    private enum class ControlOption {
        JOYSTICK, CONTROLLER
    }

    private val controlOption1 = ControlOption.JOYSTICK
    private val controlOption2 = ControlOption.JOYSTICK

    val drive by when (controlOption1) {
        ControlOption.JOYSTICK -> get { joystick1.y }
        ControlOption.CONTROLLER -> get { controller1.getY(GenericHID.Hand.kLeft) }
    }

    val turn by when (controlOption1) {
        ControlOption.JOYSTICK -> get { joystick1.x }
        ControlOption.CONTROLLER -> get { controller1.getX(GenericHID.Hand.kRight) }
    }
}
