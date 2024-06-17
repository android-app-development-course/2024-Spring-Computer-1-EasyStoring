from django.contrib import admin
from django.urls import path, include

import web.views

urlpatterns = [
    # 为web应用配置一个入口
    path('admin/', admin.site.urls),
    path('getlist/', web.views.getlist),
    path('askGPT/',web.views.askGPT),
    path('save/',web.views.saveToDB),
    path('getUsername',web.views.getUsername),
    path('checkUser',web.views.checkUser),
    path('registerUser',web.views.registerUser),
    path('syncFromDevice',web.views.syncFromDevice),
    path('syncFromServer',web.views.syncFromServer),
]
