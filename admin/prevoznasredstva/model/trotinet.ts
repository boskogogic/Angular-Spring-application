import { Iznajmljivanje } from "./iznajmljivanje"
import { Kvar } from "./kvar"
import { Proizvodjac } from "./proizvodjac"

export interface Trotinet {
     id: number,
    objectId: string,
        datumNabavke: string,
        cijenaNabavke: string,
        proizvodjac: Proizvodjac
        model: string,
        pokvaren: boolean,
            kvarovi: Kvar[],
            iznajmljeno: boolean,
            iznajmljivanje: Iznajmljivanje[],
        slika: string,
        maksimalnaBrzina: string

}
