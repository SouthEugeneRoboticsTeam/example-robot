package org.team0000.example

import org.sert2521.sertain.events.onEnable
import org.sert2521.sertain.robot

// The robot function does all necessary work to set up the robot.
suspend fun main() = robot {
    // onEnable sets up a listener for the Enable event. In other words,
    // whenever the robot enables, this code will run.
    onEnable {
        println("Hello, world!")
    }
}
