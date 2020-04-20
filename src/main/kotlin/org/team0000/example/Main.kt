package org.team0000.example

import org.sert2521.sertain.events.onAuto
import org.sert2521.sertain.events.onEnable
import org.sert2521.sertain.robot
import org.sert2521.sertain.subsystems.add
import org.sert2521.sertain.units.s
import org.team0000.example.drivetrain.Drivetrain
import org.team0000.example.drivetrain.driveForwardFor

// Subsystems can be acquired and used through a `Worker`. These are made by calling `add`.
// Make sure to do this in your main file so it gets initialized right away.
val drivetrain = add<Drivetrain>()

// The `robot` function does all necessary work to set up the robot.
suspend fun main() = robot {
    // `onEnable` sets up a listener for the `Enable` event. In other words,
    // whenever the robot enables, this code will run.
    onEnable {
        println("Hello, world!")
    }

    // Here we tell the robot to drive forward for five seconds during autonomous mode
    onAuto {
        driveForwardFor(5.s)
    }
}
