//
//  HomeScreen.swift
//  iosApp
//
//  Created by Jorge Gimeno Latas on 21/9/25.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync

struct HomeScreen: View {
    
    @StateViewModel
    var viewModel = HomeViewModel(repository: DiHelper().repository)
    
    
    var body: some View {
        if !viewModel.characters.isEmpty {
            NavigationStack{
                VStack{
                    Text("Vegeta Edition").font(.title).bold().foregroundColor(Color(.backgroundTertiary))
                    ScrollView{
                        LazyVStack{
                            ForEach(viewModel.characters,id:\.self){ character in
                                NavigationLink(destination: {DetailScreen(id: character.id)}){
                                    CharacterItem(item: character)
                                }
                            }
                        }
                    }
                }.background(Color(.backgroundPrimary))
            }
        } else {
            ProgressView()
        }
           
    }
    
}

#Preview {
    HomeScreen()
}
