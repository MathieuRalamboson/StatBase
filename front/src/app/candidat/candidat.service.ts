import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from './candidat';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class CandidatService {
  constructor(private http: HttpClient) { }

  private _server = environment.webservice.server;

  /**
   * Retourne une liste de tous les candidats
   * @returns 
   */
  public getAllCandidat(): Observable<any> {
    const url = `${this._server}/candidat/getAll`;
    return this.http.get<Candidate[]>(url)
  }

  /**
   * Effectuer la requete de création d'un candidat
   * @param params données du candidat 
   * @returns 
   */
  public create(params:any): Observable<any> {
    const url = `${this._server}/candidat/create`;
    return this.http.post<any>(url,params);
  }

  /**
   * Effectue la requete de modification d'un candidat
   * @param id identifiant du candidat à modifier
   * @param params données du candidat
   * @returns 
   */
  public update(id:number , params:any): Observable<any> {
    const url = `${this._server}/candidat/update/${id}`;
    return this.http.put<any>(url, params);
  }

  /**
   * Effectue la requete de suppression d'un candidat
   * @param id identifiant du candidat à supprimer
   * @returns 
   */
  public delete(id:number): Observable<any> {
    const url = `${this._server}/candidat/delete/${id}`;
    return this.http.delete<any>(url);
  }

  /**
   * Effectue la requete de récupération de données sur un candidat
   * @param id identifiant du candidat
   * @returns 
   */
  public find(id:number): Observable<any> {
    const url = `${this._server}/candidat/find/${id}`;
    return this.http.get<any>(url);
  }
  
}
