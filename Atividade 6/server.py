from typing import Union

from fastapi import FastAPI, Request
from fastapi.responses import JSONResponse
from starlette.exceptions import HTTPException as StarletteHTTPException

from datetime import datetime

app = FastAPI()

@app.get("/")
def home():
    return {"message":"Hello World"}

@app.get("/time")
def home():
    return {"message": datetime.now().strftime("%H:%M:%S")}

@app.get("/date")
def home():
    return {"message": datetime.now().strftime("%d-%m-%Y")}

@app.get("/datetime")
def home():
    return {"message": datetime.now().strftime("%d-%m-%Y %H:%M:%S")}

@app.exception_handler(StarletteHTTPException)
async def http_exception_handler(request: Request, exc: StarletteHTTPException):
    return JSONResponse({"message":"You're not supposed to be here..." })