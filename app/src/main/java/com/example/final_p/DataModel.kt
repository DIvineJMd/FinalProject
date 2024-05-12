package com.example.final_p

import android.content.Context
import android.location.Geocoder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class DataModel : ViewModel() {

    private var _countyCode by mutableStateOf("abhi nhi aaya")

    fun country(): String {
        return _countyCode
    }

      fun setCountry(context: Context, lat: Double, long: Double) {

            val geocoder = Geocoder(context, Locale.getDefault())
            try {
                val addresses = geocoder.getFromLocation(lat, long, 1)
                if (addresses != null) {
                    _countyCode = if (addresses.isNotEmpty()) {
                        (addresses[0].countryCode ?: "NULL")
                    } else {
                        "NULL"
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _countyCode = "NULL"
            }

    }
}
