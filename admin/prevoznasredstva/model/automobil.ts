import { Iznajmljivanje } from "./iznajmljivanje";
import { Kvar } from "./kvar";
import { Proizvodjac } from "./proizvodjac";

export interface Automobil {
    id: number,
    objectId: string,
    datumNabavke: string,
    cijenaNabavke: string,
    proizvodjac: Proizvodjac
    model: string,
    opis: string,
    pokvaren: boolean,
    kvarovi: Kvar[],
    iznajmljeno: boolean,
    iznajmljivanje: Iznajmljivanje[],
    slika: string
}
