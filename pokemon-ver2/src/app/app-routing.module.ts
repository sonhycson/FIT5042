import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PokemonListComponent} from './pokeapi/pokemon-list/pokemon-list.component';
import {PokemonCrudComponent} from './pokemon-crud/pokemon-crud.component';
import {PokemonDetailComponent} from './pokeapi/pokemon-detail/pokemon-detail.component';

import {AppComponent} from './app.component';


const appRoutes: Routes = [
   { path: 'pokemons', component: PokemonListComponent },
  { path: 'crud-app', component: PokemonCrudComponent },
   { path: 'pokemon/:id', component: PokemonDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
