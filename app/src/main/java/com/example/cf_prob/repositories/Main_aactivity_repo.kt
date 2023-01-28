package com.example.cf_prob.repositories

import com.example.cf_prob.Services_and_interface.interface_1

class Main_aactivity_repo() {
    suspend fun getAllproblems() = interface_1.getInstance().getDestinationList();
}