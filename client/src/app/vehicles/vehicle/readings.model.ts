import {Tire} from './tire.model';

export class Reading {

  constructor(public  vin: string,
              public  latitude: number,
              public  longitude: number,
              public timestamp: any,
              public  fuelVolume: number,
              public speed: number,
              public engineHp: number,
              public checkEngineLightOn: number,
              public engineCoolantLow: number,
              public cruiseControlOn: number,
              public engineRpm: number,
              public tire:Tire) {}
}
