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
sealed interface Concode {
    data class Success(val concode: String) : Concode
    object Error : Concode
    object Loading : Concode
}
class DataModel : ViewModel() {
    private var _countyCode by mutableStateOf<Concode>(Concode.Loading)



    fun country(): Concode {
        return _countyCode
    }

      fun setCountry(context: Context, lat: Double, long: Double) {

            val geocoder = Geocoder(context, Locale.getDefault())
            try {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(lat, long, 1)
                _countyCode = if (addresses != null && addresses.isNotEmpty()) {
                    Concode.Success(addresses[0].countryCode ?: "NULL")
                } else {
                    Concode.Error
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _countyCode = Concode.Error            }

    }
}
