package org.team0000.example.drivetrain

import kotlinx.coroutines.CoroutineScope
import org.sert2521.sertain.motors.MotorController
import org.sert2521.sertain.subsystems.Subsystem
import org.sert2521.sertain.telemetry.Table
import org.sert2521.sertain.telemetry.linkTableEntry
import org.sert2521.sertain.units.AngularUnit
import org.sert2521.sertain.units.degrees
import org.team0000.example.MotorIds

class Drivetrain : Subsystem() {
    private val table = Table("Drivetrain")

    private val leftDrive = MotorController(MotorIds.leftFront, MotorIds.leftRear)
    private val rightDrive = MotorController(MotorIds.rightFront, MotorIds.rightRear)

    fun leftPose(unit: AngularUnit) = leftDrive.position(unit)
    fun rightPose(unit: AngularUnit) = leftDrive.position(unit)

    fun arcadeDrive(drive: Double, turn: Double) {
        leftDrive.setPercentOutput(drive + turn)
        rightDrive.setPercentOutput(drive - turn)
    }

    fun tankDrive(left: Double, right: Double) {
        leftDrive.setPercentOutput(left)
        rightDrive.setPercentOutput(right)
    }

    override fun CoroutineScope.setup() {
        linkTableEntry("LeftPose", table) { leftPose(degrees) }
        linkTableEntry("RightPose", table) { rightPose(degrees) }
    }
}
