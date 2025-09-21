//
//  CharacterItem.swift
//  iosApp
//
//  Created by Jorge Gimeno Latas on 21/9/25.
//

import SwiftUI
import Shared
import Kingfisher

struct CharacterItem: View {

    let item: CharacterModel
    
    var body: some View {
        ZStack{
            DiamondShape()
                .fill(Color(.backgroundSecondary))
                .frame(width: 300, height: 300)
                .overlay(DiamondShape().stroke(Color(.backgroundTertiary), lineWidth: 9))
                .rotationEffect(Angle(degrees: 180))
            KFImage(URL(string: item.image))
                .placeholder {
                    ProgressView()
                }
                .resizable()
                .scaledToFit()
                .frame(maxWidth: 100, maxHeight: 250)
            
            VStack{
                Spacer()
                VStack{
                    Text(item.name).font(.headline)
                    Text(item.race).font(.subheadline)
                }.frame(maxWidth: .infinity)
                    .padding(8)
                    .background(RoundedRectangle(cornerRadius: 10).stroke(Color(.backgroundTertiary), lineWidth: 9)
                        .background(Color(.backgroundSecondary)))
            }
            
        }.padding(.horizontal,24).padding(.vertical, 12)
    }
}

#Preview {
    CharacterItem(item: CharacterModel(id:1, name: "Jorge", ki: "0 ki", race: "Human", gender: "Male", description: "Utebano", image: "https://dragonball-api.com/characters/vegeta_normal.webp"))
}
