import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidat} from '../candidat';
import { CandidatService } from '../service/candidat.service';

@Component({
  selector: 'app-candidat',
  templateUrl: './candidat.component.html',
  styleUrls: ['./candidat.component.scss']
})
export class CandidatComponent implements OnInit {
  // Liste de candidat stocker
  public candidats: Candidat[] = [];

  constructor(private candidatService: CandidatService) { }

  ngOnInit(): void {
    this.getAllCandidat();
  }

  // On rafraichit la page en cas de modification
  refreshCurrentPage() {
    window.location.reload();
  }

  public getAllCandidat() {
    this.candidatService.getAllCandidat().subscribe( data => {
      console.log(data);
      this.candidats = data;
    },
    (error: HttpErrorResponse) => {
      console.log("Erreur: Récupération de la liste des candidats.");
    });
  }

}
