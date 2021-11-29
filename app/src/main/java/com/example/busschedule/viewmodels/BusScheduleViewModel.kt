package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import com.example.busschedule.database.Schedule.Schedule
import com.example.busschedule.database.dao.ScheduleDao


class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {}

fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)