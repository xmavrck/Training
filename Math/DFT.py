
# Import Math functions
import math

pie = math.pi
cosine = math.cos
sine = math.sin


# Define Power term to be used in the sequence
def powerterm(x):
    return complex(cosine(x), sine(x))

# Define a DFT function that returns a frequency domain signal of a time domain signal
# n is the number of samples in the input signal
def DFT(input_time_signal):
    n = int(len(input_time_signal))
    return [sum((input_time_signal[k] * powerterm(-2 * pie * i * k / n) for k in range(n))) for i in range(n)]

# Define a function IDFT to convert incoming frequency domain signals to time domain
def IDFT(input_frequency_signal):
    n = len(input_frequency_signal)
    return [sum((input_frequency_signal[k] * powerterm(2 * pie * i * k / n) for k in range(n))) / n for i in range(n)]

# Main/driver function
if __name__ == "__main__":
    wave = list(map(int, input("enter a digitized wave").split(",")))
    frequency = DFT(wave)
    time = IDFT(frequency)
    print ("time to frequency domain conversion \n")
    print (frequency, "\n")
    print ("frequency to time domain conversion \n")
    print([x.real for x in time])
    pass
