import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Activity.model.CurrentResponseApi
import com.example.weatherapp.Repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableLiveData<CurrentResponseApi?>()
    val weatherData: LiveData<CurrentResponseApi?> = _weatherData

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> = _errorState

    fun loadCurrentWeather(lat: Double, lng: Double, unit: String) {
        viewModelScope.launch {
            try {
                val response = weatherRepository.getCurrentWeather(lat, lng, unit)
                if (response.isSuccessful) {
                    _weatherData.postValue(response.body())
                    _errorState.postValue(false)
                } else {
                    _errorState.postValue(true)
                }
            } catch (t: Throwable) {
                _errorState.postValue(true)
                // Hata durumunu yönetebilirsin
            }
        }
    }
}
