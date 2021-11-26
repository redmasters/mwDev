import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CorpoComponent} from "./corpo/corpo.component";
import {SobreComponent} from "./sobre/sobre.component";
import {ContatoComponent} from "./contato/contato.component";

const routes: Routes = [
  {path: '', component: CorpoComponent},
  {path: 'sobre', component: SobreComponent},
  {path: 'contato', component: ContatoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
