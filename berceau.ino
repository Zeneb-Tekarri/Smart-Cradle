#include "arduinoFFT.h"
//#include <SoftwareSerial.h>
#include <Servo.h>
#define SAMPLES 128             //SAMPLES-pt FFT. Must be a base 2 number. Max 128 for Arduino Uno.
#define SAMPLING_FREQUENCY 2048 //Ts = Based on Nyquist, must be 2 times the highest expected frequency.

arduinoFFT FFT = arduinoFFT();
Servo monServomoteur;
//SoftwareSerial espSerial(5, 6);
unsigned int samplingPeriod;
unsigned long microSeconds;
double vReal[SAMPLES]; //create vector of size SAMPLES to hold real values
double vImag[SAMPLES]; //create vector of size SAMPLES to hold imaginary values
long prevMillis = 0;
int delay1 = 700;
int a = 0;
String msg ;
String str ; 
int comp=0 ;
void setup() 
{
    Serial.begin(115200); //Baud rate for the Serial Monitor
    monServomoteur.attach(13 );
    samplingPeriod = round(1000000*(1.0/SAMPLING_FREQUENCY)); //Period in microseconds 
     pinMode (2,OUTPUT); 
    digitalWrite(2,LOW);
}
 
void loop() 
{  
    /*Sample SAMPLES times*/
    for(int i=0; i<SAMPLES; i++)
    {
        microSeconds = micros();    //Returns the number of microseconds since the Arduino board began running the current script. 
     
        vReal[i] = analogRead(0); //Reads the value from analog pin 0 (A0), quantize it and save it as a real term.
        vImag[i] = 0; //Makes imaginary term 0 always

        /*remaining wait time between samples if necessary*/
        while(micros() < (microSeconds + samplingPeriod))
        {
          //do nothing
        }
    }
 
    /*Perform FFT on samples*/
    FFT.Windowing(vReal, SAMPLES, FFT_WIN_TYP_HAMMING, FFT_FORWARD);
    FFT.Compute(vReal, vImag, SAMPLES, FFT_FORWARD);
    FFT.ComplexToMagnitude(vReal, vImag, SAMPLES);

    /*Find peak frequency and print peak*/
    double peak = FFT.MajorPeak(vReal, SAMPLES, SAMPLING_FREQUENCY);
    Serial.print(peak);     //Print out the most dominant frequency.
    Serial.print(analogRead(A0));
   
   
   if (peak >900  and  analogRead(A0)> 370){ a=1;
                                              prevMillis = millis() ;}
    while (a!=0 and millis() - prevMillis < delay1){ 
           if (peak >600  and  analogRead(A0)> 370){a =a+1;} } 
    Serial.println(millis() - prevMillis);
    Serial.println(a) ;
    Serial.println(analogRead(A0)) ;
              
      if (a>2){
        Serial.println(a); 
        Serial.println ("cris de bébé");
        //msg = "  cris de bébé";
        Serial.println(analogRead(A0)) ;
                  comp = comp +1 ;
      if ( comp == 1){
                    
       for(int i=0 ; i<= 10 ; i++){
            monServomoteur.attach(13 );
            
      for (int position = 0; position <= 180; position++) {
            monServomoteur.write(position);
            delay(5);}
              
      for (int position = 180; position >= 0; position--) {
            monServomoteur.write(position);
            delay(5);}
     digitalWrite(2,HIGH);
    }
     digitalWrite(2,LOW);
      monServomoteur.detach( );
      comp = 0 ;  
    }
       a=0;} 
    
    else { Serial.println ("passssssssssssssssssssssss cris de bébé") ;
    Serial.println(analogRead(A0)) ;
    //msg = "  passsssssssssssssss cris de bébé ";
    Serial.println(a);
    monServomoteur.detach( );
    a=0; 
    prevMillis=0;}
    delay(1000);
    //str =String("coming from arduino: ")+String(analogRead(A0))+String(msg);
    //espSerial.println(str);
    
   
    
    /*Script stops here. Hardware reset required.*/
   // while (0); //do one time
}
