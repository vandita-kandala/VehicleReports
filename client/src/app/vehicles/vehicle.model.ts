export class Vehicle{

  constructor(public  vin: string,
              public  make: string,
              public  model: string,
              public year: number,
              public  readlineRpm: number,
              public maxFuelVolume: number,
              public lastServiceDate: string) {}
}
