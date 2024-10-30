import requests
from plyer import notification
import time

API_KEY = "your_api_key_here"  # Replace with your OpenWeatherMap API key
CITY = "your_city_here"

def get_weather():
    url = f"http://api.openweathermap.org/data/2.5/weather?q={CITY}&appid={API_KEY}&units=metric"
    response = requests.get(url)
    data = response.json()
    temp = data["main"]["temp"]
    weather_desc = data["weather"][0]["description"]
    return f"{CITY.capitalize()} Weather: {temp}°C, {weather_desc.capitalize()}"

def notify():
    weather_info = get_weather()
    notification.notify(
        title="Weather Update",
        message=weather_info,
        timeout=10
    )

# Run notifications every hour
while True:
    notify()
    time.sleep(3600)
